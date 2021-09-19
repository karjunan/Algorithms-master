function twoNumberSum(arr,targetSum) {
    arr.sort((a,b) => {
        return a-b;
    });
    console.log(arr);
    var i = 0;
    var j = arr.length - 1;
    var output = [];
    while( i < j) {
        if((arr[i] + arr[j]) > targetSum ) {
            j--
        } else if(arr[i] + arr[j] < targetSum) {
            i++;
        }else {
            var res = [arr[i],arr[j]];
            output.push(res);
            i++;
            j--;
        }
    }
    return output;

}

let arr = [3,5,-4,8,11,1,-1,6]
let targetSum = 10;

let result = twoNumberSum(arr,targetSum);
console.log(result);