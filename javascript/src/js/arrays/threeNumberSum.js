function threeNumberSum(arr, targetSum) {

        arr.sort((a,b) => a-b);

        console.log(arr);
        var result = [];
        var thirdElement = 0;
        while(thirdElement < arr.length) {
            var i = thirdElement + 1;    
            var j = arr.length - 1;
            while(i < j) {
                var currentSum = arr[thirdElement] + arr[i] + arr[j];
                if(currentSum < targetSum) {
                    i++;
                    continue;
                } else if(currentSum > targetSum) {
                    j--;
                    continue;
                } else if(currentSum === targetSum) {
                    var output = [arr[thirdElement],arr[i],arr[j]]
                    result.push(output);
                
                } else {
                    console.log("you should never reach here");
                }
                i++;
                j--;
            }
            thirdElement++;
            // console.log(result);
        }

        return result;
}

let arr = [12,3,1,2,-6,5,-8,6]
targetSum = 0;
let result = threeNumberSum(arr,targetSum)
console.log(result);