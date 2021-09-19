// let value = [10, 20, 20, 10, 30, 10]
let value = [10, 20, 20, 10, 20]


function countAllDistinceElements(value) {

  let set = new Set();

  for( let i = 0 ; i < value.length; i++) {
    if(!set.has(value[i])) {
        set.add(value[i]);
    }
  }
  return set.size;
}

console.log(countAllDistinceElements(value));