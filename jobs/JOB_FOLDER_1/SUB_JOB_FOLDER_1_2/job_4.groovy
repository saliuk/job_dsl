job('JOB_FOLDER_1/SUB_JOB_FOLDER_1_2/job_4') {
    description('This is job 4 in JOB_FOLDER_1.2.')
    steps {
        shell('echo "Running job 4 in JOB_FOLDER_1.2"')
    }
}
