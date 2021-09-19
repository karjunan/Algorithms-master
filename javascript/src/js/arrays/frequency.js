
function sameV1(input, squaredinput) {

    let frequencyCounter = {};
    for( let i = 0 ; i < squaredinput.length; i++) {
     let key = squaredinput[i];
     let value = true;
     frequencyCounter[squaredinput[i]] = true;
    }
    for(let i in input) {
        let sq = input[i] * input[i];
        if(frequencyCounter[sq]) {
            delete frequencyCounter[sq];
        } else {
            return false;
        }
    }
    return true;
}

function same(input, squaredinput) {
    
    var map = new Map();
    for(var i = 0 ; i < squaredinput.length; i++) {
        map.set(squaredinput[i],true);
    }

    for(let i = 0 ; i < input.length; i++) {
        let sqared = input[i] * input[i];
        let key = map.get(sqared);
        console.log("key is => " , key );
        if(key) {
            console.log("Map size", map.size);
            map.delete(sqared);
            // console.log();
        } else {
            return false;
        }
        
    }
    console.log(map)
    return true;
}

var input = [1,2,3];
var sqInput = [4,9,1];

// var result = same(input,sqInput);

var result = sameV1(input,sqInput);
console.log(result);

export {same,sameV1};