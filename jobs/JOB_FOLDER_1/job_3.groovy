job('Example-Job-3') {
    description('This is an example job created by Job DSL.')
//    scm {
//        git('https://github.com/your-repo.git', 'master')
//    }
    triggers {
        cron('H/15 * * * *')
    }
    steps {
        shell('echo "Hello, World JOB_3!"')
    }
}
