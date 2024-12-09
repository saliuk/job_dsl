job('job2') {
    description('This is job 2 at the root level.')
    steps {
        shell('echo "Running job 2 at the root level"')
    }
}
