function subArraySum(arr,value) {
    var i = 0;
    var j = 0;
    var sum = 0;
    var max = 0;
    if(value > arr.length ) {
        return null;
    }
    while(j < value && j < arr.length) {
        sum = sum + arr[j];
        max = sum;
        j++;
    }
    while(j < arr.length) {
        sum = sum - arr[i];
        sum = sum + arr[j];
        max = Math.max(sum,max);
        i++;
        j++;
    }   

    return max;
}

// let elements = [100,200,300,400]
// let elements = [1,4,2,10,23,3,1,0,20]
// let elements = [-3,4,0,-2,6,-1]
// let elements = [3,-2,7,-4,1,-1,4,-2,1]
let elements = [2,3]
let result = subArraySum(elements,3);
console.log(result)