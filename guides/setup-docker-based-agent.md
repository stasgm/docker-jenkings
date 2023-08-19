Docker-based Jenkins Agent setup
==============================

### Links

* <https://devopscube.com/docker-containers-as-build-slaves-jenkins/>
* <https://hub.docker.com/r/jenkins/ssh-agent>
* <https://www.jenkins.io/doc/book/using/using-agents>

### Video instructions: 
*  <https://www.youtube.com/watch?v=ymI02j-hqpU>
  
## Add ssh

### Steps

  1. Browse to <http://localhost:8081/manage/credentials/store/system/domain/_/newCredentials>
  2. Fill in the form:
     * Kind: SSH Username with private key;
     * id: jenkins
     * description: The jenkins ssh key
     * username: jenkins
     * Private Key: select Enter directly and press the Add button to insert the content of your private key file at **~/.ssh/jenkins_agent_key**
     * Passphrase: fill your passphrase used to generate the SSH key pair (leave empty if you didn’t use one at the previous step)

---

## Add a new node agent (Jenkins recommendation)

### links

* <https://devopscube.com/setup-slaves-on-jenkins-2>

### steps

  1. Browse to <http://localhost:8081/computer/>
  2. Click the 'New node' button
  3. Fill the Node/agent name and select the type; (e.g. Name: agent-1, Type: Permanent Agent) click on the Create button
  4. Fill the form:
     * Remote root directory; (e.g.: /home/jenkins/agent-1 )
     * label; (e.g.: agent-1 )
     * Launch method; (e.g.: Launch agents by SSH)
       * Host; (e.g.:  or your IP address)
       * Credentials; (e.g.: jenkins)
       * Host Key verification Strategy; (e.g.: Manually trusted key verification …​ )
  5. Press the Save button and the agent-1 will be registered, but offline for the time being. Click on it.
  6. You may need to click on the trust ssh menu item to start your agent for the first time.
  7. Open the Build-in node configuration <http://localhost:8081/manage/computer/(built-in)/configure> and set the Number of executors to 0 (in order to disable it)

---

## Install NodeJS Plugin

### Links

* <https://plugins.jenkins.io/nodejs/>
* <https://gist.github.com/MethodGrab/1462c5fcfcd4f690add8>
* <https://blog.devgenius.io/integrating-jenkins-with-a-nodejs-project-219d249b1fb2>

### Steps

  1. Open <http://localhost:8081/manage/pluginManager/available> and Install NodeJS Plugin
  2. Go to <http://localhost:8081/manage/configureTools> and scroll down to NodeJS settings
  3. Press the **Add NodeJS** button, select the required NodeJS version and press the **Save** button
  4. Type yarn in **Global npm packages to install** to install Yarn
