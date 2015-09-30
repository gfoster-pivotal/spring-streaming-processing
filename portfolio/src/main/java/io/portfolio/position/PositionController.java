package io.portfolio.position;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gfoster on 9/23/15.
 */
@RestController
public class PositionController {
	@RequestMapping(value = "/position")
	public List<Position> getPositions() {
		return null;
	}
}
