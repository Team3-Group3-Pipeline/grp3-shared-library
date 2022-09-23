def call(String repoUrl){
	 pipeline {
    agent {
        label{
            label 'jenkins-slave1'
        }
    }
    stages {
    stage('version-control'){
      steps{
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'Pw', url: 'https://github.com/Team3-Group3-Pipeline/grp3-shared-library.git']]])
      }
    }
        stage('git-clone.Lucky'){
            parallel{
                stage('Sys-Stat'){
                    steps{
                        sh 'lscpu'
                    }
                }
                stage('free-memory-in-M'){
                    steps{
                        sh'free -m'
                    }
                }
            }
        }
        stage('syscheck-BolaAjayi'){
            parallel{
                stage('free-memory'){
                    steps{
                        sh'free -g'
                    }
                }
                stage('system-stat1'){
                    steps{
                        sh'lscpu'
                    }
                }
            }
        }
        stage('BenBruno-Time'){
            parallel{
                stage('Bruno-runtime'){
                    agent {
                      label{
                      label 'jenkins-slave2'
                      }
                   }
                    steps{
                        sh 'uptime'
                    }
                }
                stage('Blok-devices'){
                    steps{
                        sh 'lsblk'
                    }
                }
            }
        }
    }
}
}
