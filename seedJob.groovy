job('SeedJob') {
    description('This job processes the repository structure and creates folders and jobs using Job DSL.')

    scm {
        git {
            remote {
                url('git@github.com:saliuk/job_dsl.git')
                credentials('github-ssh')
            }
            branch('master')
        }
    }

    triggers {
        scm('H/15 * * * *') // Poll for changes every 15 minutes
    }

    steps {
        dsl {
            // Process the structure of the repository
            text('''
                import groovy.io.FileType

                // Function to recursively create folders and jobs
                def createFolderStructure(basePath, currentPath = '') {
                    new File(basePath).eachDir { dir ->
                        def folderName = currentPath ? "${currentPath}/${dir.name}" : dir.name
                        folder(folderName) {
                            description("Folder for ${folderName}")
                        }
                        createFolderStructure(dir.absolutePath, folderName)
                    }

                    // Create jobs in the current folder
                    new File(basePath).eachFileMatch(FileType.FILES, ~/.*\\.groovy/) { file ->
                        def jobName = file.name - '.groovy'
                        def jobPath = currentPath ? "${currentPath}/${jobName}" : jobName
                        job(jobPath) {
                            description("Job created from ${file.name}")
                            steps {
                                shell("echo Running job ${jobName}")
                            }
                        }
                    }
                }

                // Start processing from the root folder in the workspace
                createFolderStructure("${WORKSPACE}/jobs")
            ''')
            removeAction('DELETE') // Removes jobs not described in the DSL
        }
    }

    publishers {
        mailer('iwan.salyuk@gmail.com', false, true) // Send email notifications
    }
}
