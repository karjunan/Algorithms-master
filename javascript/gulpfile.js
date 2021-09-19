
const {gulp} = require("gulp");
var ts = require("gulp-typescript");
var tsProject = ts.createProject("tsconfig.json");


function build () {
  return tsProject
    .src()
    .pipe(tsProject())
    .js.pipe(gulp.dest("dist"));
};

function watch() {
  gulp.watch('src');
};

gulp.task('default', () => {
  console.log("hello");
})

gulp.task('default',gulp.series('build','watch'))