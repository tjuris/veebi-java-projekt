package ee.itcollege.i377.iseseisev3;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


@Service
@Scope("singleton")
public class IncidentSimulatorServiceImpl implements IncidentService {

	private String[] locations = {"Esimene koht", "Teine koht", "Kolmas koht"};
	private String[] descriptions = {"Esimene kirjeldus", "Teine kirjeldus", "Kolmas kirjeldus"};
	private String[] statuses = {"Esimene staatus", "Teine staatus", "Muidu staatus"};
	
	
	@Override
	//@RequestMapping("/getUnresolvedIncidents")
	public List<Incident> getUnresolvedIncidents() {
		Random rand = new Random();
		int listSize = rand.nextInt(10);
		List<Incident> result = new LinkedList<Incident>();
		for (int i=0; i<listSize; i++){
			result.add(generateIncident(rand));
		}
		return result;
	}

	private Incident generateIncident(Random rand) {
		Incident newIncident = new Incident();
		Long start = Math.abs(System.currentTimeMillis() - rand.nextLong());
		newIncident.setStart(new Date(start));
		newIncident.setEnd(new Date(start + rand.nextLong()));
		newIncident.setInvolvedGuardCount(rand.nextInt(100));
		newIncident.setLocation(locations[rand.nextInt(3)]);
		newIncident.setDescription(descriptions[rand.nextInt(3)]);
		newIncident.setStatus(statuses[rand.nextInt(3)]);
		return newIncident;
	}

}
