"use strict";
let value = [10, 20, 20, 10, 20];
function distinctElement(value) {
    let set = new Set(value);
    console.log(set);
    return set.size;
}
console.log(distinctElement(value));
