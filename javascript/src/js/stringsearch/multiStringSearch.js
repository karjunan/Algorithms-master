function multiStringSearch(bigString, smallStrings) {
    // Write your code here.
    var map = new Map();
    var k = 1;
    var str = bigString.split(" ")
    for(var i of str) {
        if(map.get(i)) {
            var result = map.get(i);
            result = result + 1;
            map.set(i,result)
        } else {
            map.set(i,1);
        }
    }
    console.log(map);

    var bool = []
    var k = 0;
    for(var i of smallStrings) {
         if(map.get(i)) {
             bool[k] = true;
             var result = map.get(i);
             result = result-1;
             if(result === 0){
                 map.delete(i);
             }
         } else {
            bool[k] = false;
         }
         k++;
    }
    for(var i of bool) {
        

    }
    console.log(bool);
}

// let bigString = "this is a big string"
// let smallStrings = ['this','yo','is','a','bigger', 'string','kappa']
let bigString = "Mary goes to the shopping center every week."
let smallStrings = ["to","Mary","centers","shop","shopping","string","kappa"]

multiStringSearch(bigString,smallStrings)
  
