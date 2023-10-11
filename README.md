# ASCII Art

The idea of this project is to load images, translate them into ASCII ART images, optionally apply filters, and save them.

### The app will be a simple console-executable, that:

Loads an image \
Translates the image into ASCII art \
Applies filters if required – no filters by default \ 
Outputs the image into an output (console, file, …)

When inside the sbt shell (after running the sbt command), the run command can look like this:
```
run --image "../images/test-image.jpg" --rotate +90 --scale 0.25 --invert --output-console
```
```
run --image "test-image.jpg" --output-file "../outputs/output.txt"
```
```
run --image "test-image.jpg" --rotate +89 --invert --rotate +1 --output-file "../outputs/output.txt" --output-console --table "bourke-small"
```
