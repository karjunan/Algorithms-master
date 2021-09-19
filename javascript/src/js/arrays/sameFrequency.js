function sameFrequency(a,b) {

    var first = a;
    var obj = {}
    while(first > 0) {
        var mod = first % 10
        if(obj[mod]) {
            obj[mod] = obj[mod] + 1
        } else {
            obj[mod] = 1;
        }
        first = Math.floor(first / 10);
        // console.log(obj);
    } 
    first = b;
    while(first > 0) {
        var mod = Math.floor(first % 10);
        if(mod in obj ) {
            var val = obj[mod];
            if(val > 1) {
                obj[mod] = obj[mod] - 1 
            } else {
                delete obj[mod]
            }
        } else {
          return false  
        }
        first = Math.floor(first / 10);
    }
  
    if(Object.keys(obj).length > 0) {
        return false;
    }

    return true
}


// let result = sameFrequency(128,821)
// let result = sameFrequency(34,14)
// let result = sameFrequency(3589578,5879385)
let result = sameFrequency(22,222)
console.log(result);

// export {sameFrequency}