function binarySearch(elements, searchElement) {

    var i = 0;
    var j = elements.length-1;
    
    while( i <= j) {
        var mid = Math.floor((i+j)/2)
        if(searchElement < elements[mid]) {
            j = mid-1;
            mid = (i+j)/2
        } else  if (searchElement > elements[mid]) {
            i = mid+1;
            mid = (i+j)/2
        } else {
            return "Element found at index " + mid;
        }
    }

    return "Element not present"

}

// 7/2 = 3
let elements = [2,4,5,6,7,8,9,10]

let result = binarySearch(elements,10);

console.log(result)

export {binarySearch}