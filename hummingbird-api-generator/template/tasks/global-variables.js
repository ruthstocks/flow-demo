var args = require('minimist')(process.argv.slice(2));

var ns = args.groupId || "com.vaadin.hummingbird";
var nspath = ns.replace(/\./g,'/');
var currentDir = process.cwd() + '/';

var clientDirBase = currentDir + (args.pom ? 'pom/' : 'target/generated/') + (args.javaDir || 'src/main/java/').replace(/,+$/, "");
var publicDirBase = currentDir + (args.pom ? 'pom/' : 'target/generated/') + (args.resourcesDir || 'src/main/resources/').replace(/,+$/, "");

var clientDir = clientDirBase + '/' + nspath + "/";
var publicDir = publicDirBase + "/VAADIN/";

module.exports = {
  ns: ns,
  nspath: nspath,
  artifactId: args.artifactId || "hummingbird-polymer-elements",
  currentDir: currentDir,
  clientDirBase: clientDirBase,
  publicDirBase: publicDirBase,
  clientDir: clientDir,
  publicDir: publicDir,
  bowerDir: publicDir + "bower_components/",
  bowerPackages: args.package ? args.package.split(/[, ]+/) : null
};