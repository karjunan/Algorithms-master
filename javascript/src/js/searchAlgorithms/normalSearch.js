function normalSearch(input, searchElement) {
    for(var i = 0 ; i < input.length; i++) {
        if(input[i] == searchElement) {
            return "Element Found is = "+ searchElement + " at index: "+ i
        }
    }
    return "Element Not Found"
}

let elements = [1,2,3,4,5,6]
let result = normalSearch(elements,2);
console.log(result)

export {normalSearch}