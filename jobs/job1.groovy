job('job1') {
    description('This is job 1 at the root level.')
    steps {
        shell('echo "Running job 1 at the root level"')
    }
}
