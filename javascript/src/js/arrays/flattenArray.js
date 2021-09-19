function flattenArray(arr) {
 var finalResult = []
 helper(arr,0,finalResult);
 return finalResult;
}

function helper(arr,next, result) {
    if( arr.length !== next) {
        for(var k of arr[next]) {
            result.push(k);
        }
        next++;
        helper(arr,next, result);
      
    }

}

var arr = [[1,23],[43,56,7,8],[34,12]]
var result = flattenArray(arr);
console.log(result);