folder('JOB_FOLDER_1') {
    description('Folder for JOB_FOLDER_1')
}

folder('JOB_FOLDER_1/SUB_FOLDER_1_2') {
    description('Sub-folder for JOB_FOLDER_1/SUB_FOLDER_1_2')
}

job('JOB_FOLDER_1/SUB_FOLDER_1_2/job_4') {
    description('This is job 4 inside SUB_FOLDER_1_2 of JOB_FOLDER_1. It runs script4.sh from the scripts folder.')
    steps {
        shell('bash ${WORKSPACE}/scripts/script4.sh')
    }
}
