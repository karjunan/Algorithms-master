
function bits(arr) {
    var result = []
    helper(arr,[], result);
    console.log(result);
}

function helper(arr, arr1,result) {
 if(arr.length <= 0) {
      console.log(arr1);
      return;
 }
 for(var i = 0 ; i < arr.length; i++) {
     var temp = arr.shift();
     arr1.push(temp);
     helper(arr,arr1,result);
     arr1.shift();
     arr.push(temp);

 }
}

let arr = [0,0,0]   
let result = bits(arr);
console.log(result)