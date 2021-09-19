function quickSelect(arr, k) {

    console.log(k , arr.length)
    if(k >= (arr.length)) {
        console.log("K is greater than the length of the array");
        return -1;
    }
    var start = 0;
    var end = arr.length - 1;
    var pivot = helper(arr,start,end);
    if(pivot == k) {
        return arr[pivot];
    }
    while( true ) {
        if(k < pivot) {
            pivot = helper(arr, 0, pivot-1) 
        } else if( k > pivot) {
            pivot = helper(arr,pivot+1, end)
        } else {
            return arr[pivot];
        }
        
    }
    
}

function helper(arr,start,end) {
    if(end <= start) {
        return end;
    }
    var pivot = partition(arr,start,end)
    console.log("Pivot value is => ", pivot);
    return pivot;
}
function partition(arr,start,end) {

    var pivot = start;
    var i = start + 1;
    var j = end

    while( i <= j) {
        if(arr[i] <= arr[pivot]) {
            i++;
        } else if(arr[j] >= arr[pivot]) {
            j--;
        } else {
            swap(i,j,arr);
            i++;
            j--;
        }
    }
    swap(pivot,j,arr);
    console.log("Elements after partitioning => " + arr, " at index " ,j );
    return j;
}

function swap(a,b,arr) {
    var temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}
// let array = [8,5,2,9,7,6,3]
let array = [9,8,7,6,5,4]
// let array = [12,1,3,22,4,1,2]
let k = 5;

// let result = pivot(array,0,array.length-1, k);
let result = quickSelect(array, k-1);
console.log("Result is => ", result)
// console.log("Pivot is => ", array, " =======> ")
