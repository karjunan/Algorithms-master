function twoNumberSum(arr,targetSum) {

    var obj = {};
    for(var i of arr) {
        if(obj[i]) {
            obj[i] = true;
        } else {
            obj[i] = false;
        }
    } 
    console.log(obj);
    for(var i = 0 ; i < arr.length; i++) {
        var result = targetSum - arr[i];
        console.log("Result is => ", result);
        if(result in obj && result != arr[i]) {
            return [arr[i],result];
        }
    }
    return [];
}


let arr = [3,5,-4,8,11,1,-1,6]
let targetSum = 10;

let result = twoNumberSum(arr,targetSum);
console.log(result);