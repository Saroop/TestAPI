import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Set;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.treewalk.TreeWalk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class TestMain {

	public static void main(String[] args) throws GitAPIException, IOException {
		
		//System.out.println(convertArrayToYamlCollection("type: select, min: 1, max: 8, options: [TRACE, DEBUG, INFO, WARN, ERROR]"));
		
		 //convertYamlToJsonWithFullMetadata();
		
		 convertYamlToJsonWithTypeInfo();
		
		/*
		 * String filename = "C:\\projects\\sabre\\hgw-devscott.yml";
		 * 
		 * 
		 * Stream<String> lines = Files.lines(Paths.get(filename)); String data =
		 * lines.map(line -> { return line.replace("###", "$$$");
		 * }).collect(Collectors.joining("\n")); lines.close();
		 * 
		 * ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory()); Object obj =
		 * yamlMapper.readValue(data, Object.class); ObjectMapper jsonMapper = new
		 * ObjectMapper();
		 */
		
		/*
		 * String yamlData = "logging:\r\n" + "  level:\r\n" +
		 * "    org.springframework.cloud.gateway: TRACE ### {\"type\": \"text/number/radio/select\", \"min\": 1, \"max\": 8, \"options\": [\"TRACE\", \"DEBUG\", \"INFO\", \"WARN\", \"ERROR\"]}"
		 * ;
		 * 
		 * String[] commentedData = yamlData.split("###"); ObjectMapper objMapper = new
		 * ObjectMapper();
		 * 
		 * System.out.println(objMapper.readValue(commentedData[1], UIMetadata.class));
		 */
		/*
		 * String content = "{\"predicates\":                [\r\n" +
		 * "                  \"HGWRouteEnabled=cb_localmock\",\r\n" +
		 * "                  \"Path=/api/print\",\r\n" +
		 * "                  \"Header=rppc-agent, local\"\r\n" +
		 * "               ],\r\n" + "               \"filters\":                [\r\n"
		 * +
		 * "                  \"RewritePath=/(?<segment>.*), /mock/my/test/service\",\r\n"
		 * + "                  \"GWInitialRootFilter=4000\",\r\n" +
		 * "                  \"GWServerPreferenceATHFilter=TestPool\",\r\n" +
		 * "                  \"GWSystemLoadBalancerFilter=roundRobinLoadBalancer, rrBalancer1\",\r\n"
		 * + "                  \"GWThrottleFilter\",\r\n" +
		 * "                                    {\r\n" +
		 * "                     \"name\": \"GWRetryFilter\",\r\n" +
		 * "                     \"args\":                      {\r\n" +
		 * "                        \"retries\": 5,\r\n" +
		 * "                        \"attempts\": 2,\r\n" +
		 * "                        \"statuses\": \"BAD_GATEWAY\",\r\n" +
		 * "                        \"backoff\":                         {\r\n" +
		 * "                           \"firstBackoff\": \"10ms\",\r\n" +
		 * "                           \"maxBackoff\": \"50ms\",\r\n" +
		 * "                           \"factor\": 2,\r\n" +
		 * "                           \"basedOnPreviousValue\": false\r\n" +
		 * "                        }\r\n" + "                     }\r\n" +
		 * "                  }\r\n" + "               ]}";
		 */
		 
		
		/*
		 * JsonNode mainNode = jsonMapper.readTree(content);
		 * 
		 * JsonNode duplicateNode = jsonMapper.readTree(content);
		 */
		
		/*
		 * JsonNode mainNode =
		 * jsonMapper.readTree(jsonMapper.writerWithDefaultPrettyPrinter().
		 * writeValueAsString(obj));
		 * 
		 * JsonNode duplicateNode =
		 * jsonMapper.readTree(jsonMapper.writerWithDefaultPrettyPrinter().
		 * writeValueAsString(obj));
		 * 
		 * System.out.println(jsonMapper.writerWithDefaultPrettyPrinter().
		 * writeValueAsString(merge(mainNode, duplicateNode)));
		 * 
		 * //traverse(mainNode);
		 * 
		 * //System.out.println(mainNode);
		 * 
		 * 
		 * String content1 = "{\r\n" + "   \"server\": {\"port\": 8058},\r\n" +
		 * "   \"spring\": {\"application\": {\"name\": \"sample-app2\"}}\r\n" + "}";
		 * 
		 * String content2 = "{\r\n" + "   \"server\": {\"port\": 8059}\r\n" + "}";
		 */
		
		//JsonNode jsonNodeTree = new ObjectMapper().readTree(content);
		//JsonNode jsonNodeTree2 = new ObjectMapper().readTree(content2);
		
		/*
		 * Iterator<Entry<String, JsonNode>> fieldNames = jsonNodeTree.fields();
		 * fieldNames.forEachRemaining(entry -> { System.out.println("key:" +
		 * entry.getKey()); System.out.println("value:" + entry.getValue()); });
		 */
		
		
		/*
		 * System.out.println(jsonNodeTree);
		 * System.out.println(jsonNodeTree.get("server"));
		 * System.out.println(jsonNodeTree.get("server/port"));
		 * System.out.println(jsonNodeTree.at("/server/port"));
		 * System.out.println(((ObjectNode)jsonNodeTree.at("/server")).set("port", new
		 * ObjectMapper().readTree("8059"))); System.out.println(jsonNodeTree);
		 */
		 
		 
		
		//System.out.println(merge(mainNode, jsonNodeTree2));

	}
	
	public static void convertYamlToJsonWithFullMetadata() throws IOException {
		
		//String filename = "C:\\projects\\sabre\\hgw-devscott_commented.yml";
		String filename = "C:\\projects\\sabre\\test.yml";
		
		
		Stream<String> lines = Files.lines(Paths.get(filename));
	    String data = lines.map(line -> {
	    	return line.replace("###", "$$$");
	    }).collect(Collectors.joining("\n"));
	    lines.close();
	    
	    ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
		Object obj = yamlMapper.readValue(data, Object.class);
		ObjectMapper jsonMapper = new ObjectMapper();
		
		JsonNode mainNode = jsonMapper.readTree(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
		
		JsonNode duplicateNode = jsonMapper.readTree(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
		
		System.out.println(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergeWithMetadata(mainNode, duplicateNode)));
	}
	
	public static void convertYamlToJsonWithTypeInfo() throws IOException {
		
		String filename = "C:\\projects\\sabre\\hgw-devscott.yml";
		
		
		Stream<String> lines = Files.lines(Paths.get(filename));
	    String data = lines.collect(Collectors.joining("\n"));
	    lines.close();
	    
	    ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
		Object obj = yamlMapper.readValue(data, Object.class);
		ObjectMapper jsonMapper = new ObjectMapper();
		
		JsonNode mainNode = jsonMapper.readTree(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
		
		JsonNode duplicateNode = jsonMapper.readTree(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
		
		System.out.println(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(merge(mainNode, duplicateNode)));
	}
	
	public static JsonNode merge(JsonNode mainNode, JsonNode updateNode) throws JsonMappingException, JsonProcessingException {

	    Iterator<String> fieldNames = updateNode.fieldNames();

	    while (fieldNames.hasNext()) {
	        String updatedFieldName = fieldNames.next();
	        JsonNode valueToBeUpdated = mainNode.get(updatedFieldName);
	        JsonNode updatedValue = updateNode.get(updatedFieldName);

	        // If the node is an @ArrayNode
	        if (valueToBeUpdated != null && valueToBeUpdated.isArray() && 
	            updatedValue.isArray()) {
	            // running a loop for all elements of the updated ArrayNode
	        	List<JsonNode> valueNodes = new ArrayList<>();
	            for (int i = 0; i < updatedValue.size(); i++) {
	                JsonNode updatedChildNode = updatedValue.get(i);
	                // Create a new Node in the node that should be updated, if there was no corresponding node in it
	                // Use-case - where the updateNode will have a new element in its Array
	                if (valueToBeUpdated.size() <= i) {
	                    ((ArrayNode) valueToBeUpdated).add(updatedChildNode);
	                }
	                // getting reference for the node to be updated
	                JsonNode childNodeToBeUpdated = valueToBeUpdated.get(i);
	                
	                // gets individual array element and add it to the list
	                valueNodes.add(merge(childNodeToBeUpdated, updatedChildNode));
	            }
	            addTypeToArrayElements(mainNode, updatedFieldName, valueNodes);
	            
	        // if the Node is an @ObjectNode
	        } else if (valueToBeUpdated != null && valueToBeUpdated.isObject()) {
	            merge(valueToBeUpdated, updatedValue);
	        } else {
	            if (mainNode instanceof ObjectNode) {
	            	ObjectMapper objectMapper = new ObjectMapper();
	            	String child = "{ \"value\": "+ updatedValue + ","
	            			+ "\"app-console-type\": \"" + updatedValue.getNodeType().toString() + "\" }";
	            	JsonNode childObjectNode = objectMapper.readTree(child);
					/*
					 * childObjectNode.set("value", updatedValue);
					 * childObjectNode.set("app-console-type",
					 * objectMapper.readTree(updatedValue.getNodeType().toString()));
					 */
	                ((ObjectNode) mainNode).replace(updatedFieldName, childObjectNode);
	            }
	        }
	    }
	    return mainNode;
	}
	
	public static JsonNode mergeWithMetadata(JsonNode mainNode, JsonNode updateNode) throws IOException {

	    Iterator<String> fieldNames = updateNode.fieldNames();

	    while (fieldNames.hasNext()) {
	        String updatedFieldName = fieldNames.next();
	        JsonNode valueToBeUpdated = mainNode.get(updatedFieldName);
	        JsonNode updatedValue = updateNode.get(updatedFieldName);

	        // If the node is an @ArrayNode
	        if (valueToBeUpdated != null && valueToBeUpdated.isArray() && 
	            updatedValue.isArray()) {
	            // running a loop for all elements of the updated ArrayNode
	        	List<JsonNode> valueNodes = new ArrayList<>();
	            for (int i = 0; i < updatedValue.size(); i++) {
	                JsonNode updatedChildNode = updatedValue.get(i);
	                // Create a new Node in the node that should be updated, if there was no corresponding node in it
	                // Use-case - where the updateNode will have a new element in its Array
	                if (valueToBeUpdated.size() <= i) {
	                    ((ArrayNode) valueToBeUpdated).add(updatedChildNode);
	                }
	                // getting reference for the node to be updated
	                JsonNode childNodeToBeUpdated = valueToBeUpdated.get(i);
	                
	                // gets individual array element and add it to the list
	                valueNodes.add(mergeWithMetadata(childNodeToBeUpdated, updatedChildNode));
	            }
	            addTypeToArrayElements(mainNode, updatedFieldName, valueNodes);
	            
	        // if the Node is an @ObjectNode
	        } else if (valueToBeUpdated != null && valueToBeUpdated.isObject()) {
	            mergeWithMetadata(valueToBeUpdated, updatedValue);
	        } else {
	            if (mainNode instanceof ObjectNode) {
	            	ObjectMapper objectMapper = new ObjectMapper();
            		String[] updatedValueArray = updatedValue.toString().split(Pattern.quote("$$$"));
            		if (!updatedValue.isNumber()) {
            			updatedValueArray[0] = updatedValueArray[0] + "\"";
            		}
	            	String child = "{ \"value\": " + objectMapper.readTree(updatedValueArray[0]);
	            	if (updatedValueArray.length > 1) {
	            		child = child + ", \"app-console-info\": " + constructAppConsoleInfo(updatedValueArray[1]);
	            	}
	            	child = child + " }";
	            	JsonNode childObjectNode = objectMapper.readTree(child);
					/*
					 * childObjectNode.set("value", updatedValue);
					 * childObjectNode.set("app-console-type",
					 * objectMapper.readTree(updatedValue.getNodeType().toString()));
					 */
	                ((ObjectNode) mainNode).replace(updatedFieldName, childObjectNode);
	            }
	        }
	    }
	    return mainNode;
	}
	
	private static String constructAppConsoleInfo(String comments) throws IOException {
		comments = comments.replaceAll("=", ":");
		comments = comments.substring(0, comments.lastIndexOf("\""));
		comments = convertArrayToYamlCollection(comments);
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		Object metadata = mapper.readValue(comments, Object.class);
		mapper = new ObjectMapper();
		return  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(metadata);
	}
	
	private static String convertArrayToYamlCollection(String comments) {
		StringBuilder yamlString = new StringBuilder();
		List<String> options = new ArrayList<>();
		String attribute = "";
		// type: select, min: 1, max: 8, options: [TRACE, DEBUG, INFO, WARN, ERROR]
		boolean isArray = false;
		for(String comment: comments.split(",")) {
			if (comment.contains("[")) {
				isArray = true;
				attribute = comment.substring(0, comment.indexOf(":"));
				options.add(comment.substring(comment.indexOf("[") + 1)); 
			}
			else if (isArray && comment.contains("]")) {
				isArray = false;
				options.add(comment.substring(0, comment.indexOf("]")));
			}
			else if (isArray) {
				options.add(comment);
			}
			else {
				yamlString.append(comment.trim()).append("\n");
			}
		}
		if (!attribute.isEmpty()) {
			yamlString.append(attribute.trim()).append(":");
			for (String option : options) {
				yamlString.append("\n  - ").append(option.trim());
			}
		}
		return yamlString.toString();
	}

	private static void addTypeToArrayElements(JsonNode mainNode, String updatedFieldName, List<JsonNode> valueNodes)
			throws JsonProcessingException, JsonMappingException {
		String nodeContent = "\"array\": {\"value\" :[";
		String arrayContent = "";
		String comma = "";
		List<JsonNode> childNodes = new ArrayList<>();
		for (int i = 0; i < valueNodes.size(); i++) {
			// if single value field
			if (!valueNodes.get(i).isArray() && !valueNodes.get(i).fieldNames().hasNext()) {
				arrayContent = arrayContent + comma + "\"" + valueNodes.get(i).asText() + "\"";
			} else {  // complex item like retry filter in the sample
				childNodes.add(valueNodes.get(i));
			}
			comma = ", ";
		}
		if (!arrayContent.isBlank()) {
			// add simple array content to nodeContent
			nodeContent = nodeContent + arrayContent + "]";
			// update type info to the above element (array)
			nodeContent = nodeContent + ", \"app-console-type\": \"STRING\"}";
			
			// if complex elements are there, add it as another array element (array2)
			if (!childNodes.isEmpty()) {
				nodeContent = nodeContent + ",\"array2\": " + childNodes.toString();
			}
			nodeContent = "{ " + nodeContent + " }";
			ObjectMapper mapper = new ObjectMapper();
			((ObjectNode) mainNode).replace(updatedFieldName, mapper.readTree(nodeContent));
		}
	}
	
	public static void bitBucketPushExample() throws GitAPIException, IOException {
		// TODO Auto-generated method stub
				Git git = Git.cloneRepository()
						  .setURI("https://saroopg@bitbucket.org/saroopg/demo.git")
						  //.setURI( "https://github.com/Saroop/TestAPI.git" )
						  .setDirectory(Files.createTempDirectory("bitBucketDemo").toFile())
						  .setCredentialsProvider(new UsernamePasswordCredentialsProvider("saroopg", "saroop@123"))
						  .call();
				
				File myFile = new File(git.getRepository().getDirectory().getParent() + "\\config-repo\\configuration\\SampleApp-2", "testfile.yml");
				myFile.createNewFile();

				// run the add-call
				git.add().addFilepattern(".").call();

				git.commit().setMessage("added a test file for jgit integration").call();
				
				Status status = git.status().call();

				Set<String> added = status.getAdded();
				for (String add : added) {
					System.out.println("Added: " + add);
				}
				Set<String> uncommittedChanges = status.getUncommittedChanges();
				for (String uncommitted : uncommittedChanges) {
					System.out.println("Uncommitted: " + uncommitted);
				}

				Set<String> untracked = status.getUntracked();
				for (String untrack : untracked) {
					System.out.println("Untracked: " + untrack);
				}

				// Find the head for the repository
				ObjectId lastCommitId = git.getRepository().resolve(Constants.HEAD);
				System.out.println("Head points to the following commit :" + lastCommitId.getName());
				
				/*
				 * SshSessionFactory sshSessionFactory = new JschConfigSessionFactory() {
				 * 
				 * @Override protected void configure( Host host, Session session ) { // do
				 * nothing } };
				 * 
				 * git.push() .setTransportConfigCallback( new TransportConfigCallback() {
				 * 
				 * @Override public void configure( Transport transport ) { SshTransport
				 * sshTransport = ( SshTransport )transport; sshTransport.setSshSessionFactory(
				 * sshSessionFactory ); } } ) .call();
				 */
				
				git.push()
				.setCredentialsProvider(new UsernamePasswordCredentialsProvider("saroopg", "saroop@123"))
				.call();
	}
	
	public static void gitPushExample() throws GitAPIException, IOException {
		Git git = Git.cloneRepository()
				  .setURI("https://github.com/Saroop/SpringCloud.git")
				  //.setURI( "https://github.com/Saroop/TestAPI.git" )
				  .setDirectory(Files.createTempDirectory("SpringCloud").toFile())
				  .call();
		
		File myFile = new File(git.getRepository().getDirectory().getParent() + "\\config-repo\\configuration\\SampleApp-2", "testfile.yml");
		myFile.createNewFile();

		// run the add-call
		git.add().addFilepattern(".").call();

		git.commit().setMessage("added a test file for jgit integration").call();
		
		Status status = git.status().call();

		Set<String> added = status.getAdded();
		for (String add : added) {
			System.out.println("Added: " + add);
		}
		Set<String> uncommittedChanges = status.getUncommittedChanges();
		for (String uncommitted : uncommittedChanges) {
			System.out.println("Uncommitted: " + uncommitted);
		}

		Set<String> untracked = status.getUntracked();
		for (String untrack : untracked) {
			System.out.println("Untracked: " + untrack);
		}

		// Find the head for the repository
		ObjectId lastCommitId = git.getRepository().resolve(Constants.HEAD);
		System.out.println("Head points to the following commit :" + lastCommitId.getName());
		
		git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider("fc0bb73ef9c2f5ecd7c1bde1fce75250872c5490", "")).call();
	}

	public static void testGitRepoCreationLocal() throws GitAPIException, IOException {
		File localPath = File.createTempFile("JGitTestRepository", "");
		// delete repository before running this
		Files.delete(localPath.toPath());

		// This code would allow to access an existing repository
//      try (Git git = Git.open(new File("/home/vogella/git/eclipse.platform.ui"))) {
//          Repository repository = git.getRepository();
//
//      }

		// Create the git repository with init
		try {
			Git git = Git.open(new File("C:\\Users\\M1026319\\git\\TestAPI2"));
			System.out.println("Created repository: " + git.getRepository().getDirectory());
			File myFile = new File(git.getRepository().getDirectory().getParent(), "testfile");
			if (!myFile.createNewFile()) {
				throw new IOException("Could not create file " + myFile);
			}

			// run the add-call
			git.add().addFilepattern("testfile").call();

			git.commit().setMessage("Initial commit").call();
			System.out.println("Committed file " + myFile + " to repository at " + git.getRepository().getDirectory());
			// Create a few branches for testing
			for (int i = 0; i < 10; i++) {
				git.checkout().setCreateBranch(true).setName("new-branch" + i).call();
			}
			// List all branches
			List<Ref> call = git.branchList().call();
			for (Ref ref : call) {
				System.out.println("Branch: " + ref + " " + ref.getName() + " " + ref.getObjectId().getName());
			}

			// Create a few new files
			for (int i = 0; i < 10; i++) {
				File f = new File(git.getRepository().getDirectory().getParent(), "testfile" + i);
				f.createNewFile();
				if (i % 2 == 0) {
					git.add().addFilepattern("testfile" + i).call();
				}
			}

			Status status = git.status().call();

			Set<String> added = status.getAdded();
			for (String add : added) {
				System.out.println("Added: " + add);
			}
			Set<String> uncommittedChanges = status.getUncommittedChanges();
			for (String uncommitted : uncommittedChanges) {
				System.out.println("Uncommitted: " + uncommitted);
			}

			Set<String> untracked = status.getUntracked();
			for (String untrack : untracked) {
				System.out.println("Untracked: " + untrack);
			}

			// Find the head for the repository
			ObjectId lastCommitId = git.getRepository().resolve(Constants.HEAD);
			System.out.println("Head points to the following commit :" + lastCommitId.getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private void printTreeWalkRecursive(Git git)
			throws IOException, MissingObjectException, IncorrectObjectTypeException, CorruptObjectException {
		Repository repository = git.getRepository();
		Ref head = repository.findRef("HEAD");

		// a RevWalk allows to walk over commits based on some filtering that is defined
		try (RevWalk walk = new RevWalk(repository)) {
			RevCommit commit = walk.parseCommit(head.getObjectId());
			RevTree tree = commit.getTree();
			System.out.println("Having tree: " + tree);

			// now use a TreeWalk to iterate over all files in the Tree
			// you can set Filters to narrow down the results if needed
			try (TreeWalk treeWalk = new TreeWalk(repository)) {
				treeWalk.addTree(tree);
				// not walk the tree recursively so we only get the elements in the top-level
				// directory
				treeWalk.setRecursive(true);
				while (treeWalk.next()) {
					System.out.println("found: " + treeWalk.getPathString());
				}
			}
		}
	}

	private void printCommitMessages(Git git) throws GitAPIException, NoHeadException, IOException {
		Iterable<RevCommit> logs = git.log().all().call();
		logs.forEach(revCommit -> {
			System.out.println(revCommit.getFullMessage());
		});
	}
	
	private void gitStatusExample(Git git) throws GitAPIException, NoHeadException, IOException {
		Status status = git.status().call();

		Set<String> added = status.getAdded();
		for (String add : added) {
			System.out.println("Added: " + add);
		}
		Set<String> uncommittedChanges = status.getUncommittedChanges();
		for (String uncommitted : uncommittedChanges) {
			System.out.println("Uncommitted: " + uncommitted);
		}

		Set<String> untracked = status.getUntracked();
		for (String untrack : untracked) {
			System.out.println("Untracked: " + untrack);
		}

		// Find the head for the repository
		ObjectId lastCommitId = git.getRepository().resolve(Constants.HEAD);
		System.out.println("Head points to the following commit :" + lastCommitId.getName());
	}

}
