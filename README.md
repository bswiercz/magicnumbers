# magicnumbers
Simple checker if file extension and its metadata are consistent. Currently supprts only JPG, GIF, and plain text files. You can add your own magic types using `addMagicType` method in `MagicTypes` class.

## Build

- Compile application into jar file:
```
gradle jar
```
- Then use it as follows:
```
java -jar magicnumbers-1.0.jar /path/to/file/to/check.jpg
```

## Use in your code

Use `FileLoader` helper class with static `loadFile` to load a file into byte array, then find file type:

```
MagicTypes magicTypes = new MagicTypes();
File file = new File(path);
byte[] loadedFileBytes = FileLoader.loadFile(file);
FileType foundType = magicTypes.findTypeByBytes(loadedFileBytes);
```

## To Do

- implement loading `magic.gz' magic types library
