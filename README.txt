1. Run ModSpaceEventServer to start the Hazelcast server

2. Run the rename event publisher client a number of times to publish RENAME events to the queue

	n.b. Nothing is listening to this yet...

3. Run the Navigator event reader to read events

	n.b. This will not remove the events
	
