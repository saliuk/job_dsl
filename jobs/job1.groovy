job('job1') {
    description('This is Job 1 at the root level.')
    steps {
        shell('echo "Running Job 1 at the root level"')
    }
}
