// let value = [10, 20, 20, 10, 30, 10]
let value = [1, 2, 5, 1, 7, 2, 4, 2]


function removeDuplicates(value) {

  let set = new Set();

  for( let i = 0 ; i < value.length; i++) {
    if(!set.has(value[i])) {
        set.add(value[i]);
    }
  }
  return set;
}

console.log(removeDuplicates(value));