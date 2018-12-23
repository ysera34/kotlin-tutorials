### 1. compile
```
kotlinc hello.kt -include-runtime -d hello.jar
```

### 2. execute
```
java -jar hello.jar
```

### 3. code inspect
```
javap -cp hello.jar HelloKt
```