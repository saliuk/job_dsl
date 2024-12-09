job('job1') {
    description('This is Job 1 at the root level. It runs script1.sh from the scripts folder.')
    steps {
        shell('bash ${WORKSPACE}/scripts/script1.sh')
    }
}
