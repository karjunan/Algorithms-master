function fourNumberSum(arr, targetSum) {
    arr.sort();
    var end = arr.length-1;
    var sum = 0;
    for(var start = 0 ; i < arr.length; i++) {
        var firstResult =  arr[start] + arr[end];

    }

    return arr;
}
let array = [7,6,4,-1,1,2]
let targetSum = 16;
let result = fourNumberSum(array,targetSum);
console.log(result);

