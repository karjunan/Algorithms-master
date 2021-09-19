function merge(arr1, arr2) {

    var start = 0;
    var start1 = 0;
    var tempArr1 = [];
    var tempArr2 = [];
    var finalArray = [];
    if(arr1.length > arr2.length) {
        tempArr1 = arr1;
        tempArr2 = arr2;
    } else {
        tempArr1 = arr2;
        tempArr2 = arr1;
    }
    while(start1 < tempArr2.length && start < tempArr1.length) {
        // console.log(tempArr2, tempArr1)
        if(tempArr1[start] < tempArr2[start1]) {
            finalArray.push(tempArr1[start]);
            start++;
        } else if(tempArr1[start] > tempArr2[start1]) {
            finalArray.push(tempArr2[start1]);
            start1++;
        } else {
            finalArray.push(tempArr1[start]);
            finalArray.push(tempArr2[start1]);
            start++;
            start1++
        }
        console.log(finalArray);
    }
    while(start < tempArr1.length) {
        finalArray.push(tempArr1[start]);
        start++;
    }
    while(start1 < tempArr2.length) {
        finalArray.push(tempArr2[start1]);
        start1++;
    }
return finalArray
}

// let arr1 = [1,5,10,20,30,36,67,89,90]
// let arr2 = [2,6,9,15,17]
// let arr = [2,1,5,4,6,10,30,24,17,12,14]
let arr = [4,2]
// let result = merge(arr1,arr2);
let result = mergeSort(arr);
console.log(result);

function mergeSort(arr) {
    if(arr.length <= 1) {
        return arr;
    }
    var mid = Math.floor(arr.length/2);
    var left = mergeSort(arr.slice(0,mid));
    var right = mergeSort(arr.slice(mid));
    return merge(left,right);
}