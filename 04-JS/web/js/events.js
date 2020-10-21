function hey() {
  console.log("hey");
}

/**
 *
 * @param {the event object} eventObj
 *
 * We can gather information about what happened and the
 * state of the page from the event object. The event object
 * will be passed in and will have several properties that
 * can give you insight into what was happening.
 */
function printTheEventObject(eventObj = {}) {
  console.log(eventObj.clientX);
  console.log(eventObj.clientY);
}
