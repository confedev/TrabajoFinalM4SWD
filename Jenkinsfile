pipeline {
    agent any

    stages {
        stage('Paso 1: Compilar (Back)') {
            steps {
                script {
                    sh "echo 'Compile Code!'"
                    sh 'mvn clean compile -e'
                }
            }
        }
        stage('Paso 2: Testear (Back)') {
            steps {
                script {
                    sh "echo 'Test Code!'"
                    sh 'mvn clean test -e'
                }
            }
        }
        stage('Paso 3: Build .Jar (Back)') {
            steps {
                script {
                    sh "echo 'Build .Jar!'"
                    sh 'mvn clean package -e'
                }
            }
        }
        stage('Paso 4: Levantar Springboot APP (Back)') {
            steps {
                sh 'mvn spring-boot:run &'
            }
        }
        stage('Paso 5: Dormir(Esperar 30sg) (Back)') {
            steps {
                sh 'sleep 30'
            }
        }
        stage('Paso 6: Curl con Sleep de prueba (Back)') {
            steps {
                sh "curl -X GET 'http://localhost:8081/rest/msdxc/dxc?sueldo=500000&&ahorro=25000000'"
            }
        }
        stage('Paso 7: Test Jmeter (Back)') {
            steps {
                sh 'mvn jmeter:jmeter -Pjmeter'
            }
        }
        stage('Paso 8: Test API responses (Back)') {
            steps {
                sh 'newman run LabMod4.postman_collection.json'
            }
        }
        stage('Paso 9: Install npm modules (Front)') {
            steps {
                script {
                    sh "echo 'npm install!'"
                    sh 'npm install'
                }
            }
        }
        stage('Paso 10: Start Node Server (Front)') {
            steps {
                script {
                    sh "echo 'npm app!'"
                    sh 'node app.js &'
                }
            }
        }
        stage('Paso 11: Dormir(Esperar 30sg) (Front)') {
            steps {
                sh 'sleep 30'
            }
        }
        stage('Paso 12: Curl con Sleep de prueba  (Front)') {
            steps {
                sh "curl -X GET 'http://localhost:3000/'"
            }
        }
        stage('Paso 13: Selenium Test  (Front)') {
            steps {
                sh "echo 'Selenium Testing!'"
            }
        }
    }
}
