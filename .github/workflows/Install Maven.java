name: Java Maven CI

on: [push, pull]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout code
      uses: actions/checkout@v3

    - name: Set up Java and Maven
      uses: actions/setup-java@v3
      with:
        distribution: 'temurin'
        java-version: '17'
        cache: 'maven'

    - name: Verify Maven installation
      run: mvn -version

    - name: Build with Maven
      run: mvn clean install
