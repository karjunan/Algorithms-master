function maxSumIncreasingSubsequence(arr) {
    var temp = [arr.length]
    var pos = [arr.length];
    pos[0] = undefined;
    temp[0] = arr[0];
    for(var i = 1 ; i < arr.length; i++) {
        var maxSum = Math.min;
        for(var j = 0 ; j <= i; j++) {
            if(arr[i] > arr[j]) {
                maxSum = temp[j] + arr[i];
                if(maxSum <= 0) {
                    temp[i] = arr[i];
                    pos[i] = undefined;
                    continue;
                }
                if(maxSum > temp[i] || temp[i] === undefined) {
                    temp[i] = maxSum;
                    pos[i] = j;
                    console.log("Temp array filled with value", pos)
                }
            }
        }
    }
    var max = temp[0];
    var position = 0;
    for(var i = 1 ; i < temp.length; i++) {
        if(max < temp[i]) {
            max = temp[i];
            position = i;
        }
    }

    console.log("Position and Max => " , position,max)
    var finalResult = [];
    finalResult.push(temp[position])
    var result = new Array()
    result.unshift(arr[position])
    console.log("Result in beginning => ", finalResult)
    while(position > 0 ) {
        position = pos[position];
        console.log("position => " , position)
        if(position != undefined)
         result.unshift(arr[position]);
    }

    finalResult.push(result);
    console.log(finalResult);    
    return finalResult;
}

let array = [10,70,20,30,50,11,30]
// let array = [8, 12, 2, 3, 15, 5, 7]
// let array = [-1,1]
let result = maxSumIncreasingSubsequence(array);
console.log("Result is " + result);