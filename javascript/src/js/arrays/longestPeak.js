function longestPeak(arr) {
    var i = 1;
    var peaks = [];
    while(i < arr.length-1) {
        if(arr[i-1] < arr[i] && arr[i+1] < arr[i]) {
            peaks.push(i);
        }
        i++;
    }
    console.log(peaks)
    var k = 0
    var result = [];
    while(k < peaks.length) {
        var left = peaks[k];
        while(arr[left-1] < arr[left] ) {
            left--;
        }
        right = peaks[k];
        while(arr[right+1] < arr[right] ) {
            right++;
        }
        console.log(right, left)
        result.push((right-left)+1)
        k++;
        console.log("Result => ", result);
    }

    // console.log(peaks);
    for(var i of result) {
        console.log("I => ", i);
    }

}
let array = [1,3,2];
// let array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3];
let result = longestPeak(array);
console.log(result);