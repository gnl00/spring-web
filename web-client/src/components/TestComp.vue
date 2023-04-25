<script setup>

const strFetch = () => {
	console.log(123)

  fetch("http://localhost:8080/test/str", {
		headers: {
			'Content-Type': 'application/json'
    }
  })
    .then(res => {
	    console.log(res)
    })
    .catch(err => {
	    console.log(err.message)
    })

}

const mapFetch = () => {
	console.log(456)

	fetch("http://localhost:8080/test/map")
		.then(res => {
			console.log(res)
		})
		.catch(err => {
			console.log(err.message)
		})

}

</script>

<template>
  <h1>TestComp</h1>
  <div>
    <button @click="strFetch">strClick</button>
    <button @click="mapFetch">mapClick</button>
  </div>
</template>

<style scoped></style>