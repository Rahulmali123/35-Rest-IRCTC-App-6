package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.PassengerInfo;
import in.ashokit.bindings.TicketInfo;

@RestController
public class TicketRestController {

	@PostMapping(value = "/ticket", produces = "application/json", consumes = "application/json")
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo request) {

		TicketInfo info = new TicketInfo();
		info.setTicketId(1234);
		info.setPrn("JLJL6868");
		info.setTicketStatus("confirmed");

		return new ResponseEntity<>(info, HttpStatus.CREATED);
	}

//	@PutMapping(
//		    value = "/ticket/{ticketId}",
//		    consumes = "application/json",
//		    produces = "application/json"
//		)
//		public ResponseEntity<TicketInfo> updateTicket(
//		        @PathVariable Integer ticketId,
//		        @RequestBody PassengerInfo request) {
//
//		    TicketInfo info = new TicketInfo();
//		    info.setTicketId(ticketId);
//		    info.setPrn("JLJL6868");
//		    info.setTicketStatus("UPDATED");
//
//		    return new ResponseEntity<>(info, HttpStatus.OK);
//		}
	// Q> can we write the logic to update thedata in post request method ?

	@PostMapping(value = "/ticket/update/{ticketId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<TicketInfo> updateTicket(@PathVariable Integer ticketId, @RequestBody PassengerInfo request) {

		TicketInfo info = new TicketInfo();
		info.setTicketId(ticketId);
		info.setPrn("JLJL6868");
		info.setTicketStatus("UPDATED");

		return new ResponseEntity<>(info, HttpStatus.OK);
	}

	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<String> getTicket(@PathVariable Integer ticketId) {

		String msg = "Ticket " + ticketId + " cancelled successfully";

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/ticket/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable Integer ticketId) {

		String msg = "Ticket " + ticketId + " cancelled successfully";

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
