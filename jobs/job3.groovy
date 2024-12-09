job('job3') {
    description('This is Job 3 at the root level.')
    steps {
        shell('echo "Running Job 3 at the root level"')
    }
}
