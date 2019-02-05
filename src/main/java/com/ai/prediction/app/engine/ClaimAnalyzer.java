package com.ai.prediction.app.engine;

import java.io.BufferedReader;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.prediction.app.WeatherPredictor;
import com.ai.prediction.app.model.Claim;
import com.ai.prediction.app.model.ClaimAmountPerService;
import com.ai.prediction.app.service.ClaimAmountService;

import weka.classifiers.Classifier;
import weka.classifiers.rules.PART;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instances;

@Component
public class ClaimAnalyzer {

	static Classifier model;
	static {
		try {
			BufferedReader datafile = WeatherPredictor.readDataFile("train-claim2.txt");
			Instances train = new Instances(datafile);

			// setting class attribute if the data format does not provide this information
			// For example, the XRFF format saves the class attribute information as well
			if (train.classIndex() == -1)
				train.setClassIndex(train.numAttributes() - 1);

			// model
			model = new PART();
			model.buildClassifier(train);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public Claim analyzeClaim(Claim claim) {

		try {
			System.out.println(claim);
			// testDataCreated Here - Results play "yes"
			// Instances test = createTestData("sunny", 69d, 70d, "FALSE");

			// testDataCreated Here - Results play "yes"
			Instances test = createTestData(claim);

			// test.instance(0).setValue(play, "?");
			if (test.classIndex() == -1)
				test.setClassIndex(test.numAttributes() - 1);

			test.instance(0).setClassMissing();

			// this does the trick
			double label = model.classifyInstance(test.instance(0));
			test.instance(0).setClassValue(label);

			System.out.println(test.instance(0).stringValue(4));

			claim.setProvDetailsReq(Boolean.valueOf(test.instance(0).stringValue(4)));
			
			return claim;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	private Instances createTestData(Claim claim) {
		FastVector claimTypes = new FastVector();

		claimTypes.addElement("Medical");
		claimTypes.addElement("Dental");
		claimTypes.addElement("Pharmacy");
		FastVector serviceTypes = new FastVector();

		serviceTypes.addElement("Angiography");

		
		Attribute claimType = new Attribute("claimType", claimTypes);
		Attribute serviceType = new Attribute("serviceType", serviceTypes);
		Attribute claimAmount = new Attribute("claimAmount");
		
		FastVector cityTypes = new FastVector();
		cityTypes.addElement("Miami");
		cityTypes.addElement("Atlanta");
		cityTypes.addElement("Charlotte");
		Attribute city = new Attribute("city",cityTypes);

		FastVector provDetailsReqs = new FastVector();

		provDetailsReqs.addElement("TRUE");
		provDetailsReqs.addElement("FALSE");

		Attribute provDetailsReq = new Attribute("provDetailsReq", provDetailsReqs);

		FastVector fvWekaAttributesLinear = new FastVector();
		fvWekaAttributesLinear.addElement(city);
		fvWekaAttributesLinear.addElement(claimType);
		fvWekaAttributesLinear.addElement(serviceType);
		fvWekaAttributesLinear.addElement(claimAmount);
		fvWekaAttributesLinear.addElement(provDetailsReq);

		Instances test = new Instances("claims", fvWekaAttributesLinear, 100000);

		test.add(new DenseInstance(6));

		
		test.instance(0).setValue(claimType, claim.getClaimType().toString());
		test.instance(0).setValue(serviceType, claim.getServiceType().toString());
		test.instance(0).setValue(city, claim.getCity().toString());
		test.instance(0).setValue(claimAmount, claim.getClaimAmount());
		
		

		return test;
	}
}
