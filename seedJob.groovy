job('SeedJob') {
    description('This job creates other jobs using Job DSL scripts from the repository.')
    
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
        scm('H/15 * * * *')
    }
    
    steps {
        dsl {
            external('jobs/**/*.groovy') // Executes all Job DSL scripts in the jobs folder
            removeAction('DELETE')      // Deletes jobs that are no longer described in the DSL
        }
    }
    
    publishers {
        mailer('iwan.salyuk@gmail.com', false, true) // Email about the status of the execution
    }
}
