function duplicates() {

    var obj = {};
    for(var i = 0; i < arguments.length ; i++) {
        // console.log(arguments[i])
        if(arguments[i] in obj) {
            return true;
        } else {
            obj[arguments[i]] = true;
        }
        
        // console.log(obj);
    }
    return false;
}

// let result = duplicates(1,2,3,4)
let result = duplicates(1,2,4,3)
console.log(result)