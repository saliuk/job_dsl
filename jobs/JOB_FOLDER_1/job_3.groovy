folder('JOB_FOLDER_1') {
    description('Folder for JOB_FOLDER_1')
}

job('JOB_FOLDER_1/job_3') {
    description('This is Job 3 inside JOB_FOLDER_1.')
    steps {
        shell('echo "Running Job 3 inside JOB_FOLDER_1"')
    }
}
