Native JavaFX hello world example

install OpenJFX
```
sudo apt install openjfx
```
build source
```
./build.sh
```
run and generate configuration for native image
```
./javafx -trace -cp bin demo.Hello
```
build native image
```
./build.sh -native
```
launch 
```
./demo.hello -Djava.library.path=/usr/lib/aarch64-linux-gnu/jni -Dprism.forceGPU=true -Djavafx.debug=true -Djavafx.verbose=true -Dprism.debug=true -Dprism.verbose=true
```
