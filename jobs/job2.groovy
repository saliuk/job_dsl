job('job2') {
    description('This is Job 2 at the root level.')
    steps {
        shell('echo "Running Job 2 at the root level"')
    }
}
