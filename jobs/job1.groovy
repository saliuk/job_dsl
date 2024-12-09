job('Example-Job-1') {
    description('This is an example job created by Job DSL.')
    scm {
        git('https://github.com/your-repo.git', 'main')
    }
    triggers {
        cron('H/15 * * * *') // Запуск кожні 15 хвилин
    }
    steps {
        shell('echo "Hello, World!"')
    }
}
