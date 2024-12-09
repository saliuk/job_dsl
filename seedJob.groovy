job('SeedJob') {
    description('Processes repository structure and creates folders and jobs in Jenkins.')

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
            external('jobs/**/*.groovy')
            removeAction('DELETE')
        }

        shell('cp -R ${WORKSPACE}/scripts/* ${JENKINS_HOME}/workspace')
    }

    publishers {
        mailer('iwan.salyuk@gmail.com', false, true)
    }
}
