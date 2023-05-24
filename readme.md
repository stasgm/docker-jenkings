# Jenkins setup

## Install Docker

### Links

* <https://docs.docker.com/engine/install/ubuntu/>
* <https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04>

---

## Install Jenkins

### Links

* <https://omarghader.github.io/jenkins-nodejs-configuration/>
  
### Steps

  1. Clone a git repo: <https://github.com/stasgm/docker-jenkings>
  2. Generate ssh
     * In a terminal window run the command: `ssh-keygen -f ~/.ssh/jenkins_agent_key`
     * Provide a passphrase to use with the key (it can be empty)
  3. Inside your repo copy and rename **.env.sample** to **.env**
  4. Open **.env** and put content of **~/.ssh/jenkins_agent_key.pub** after **JENKINS_AGENT_SSH_PUBKEY=**
  5. Run the command: `docker-compose up -d`

### Unlocking Jenkins

  1. Browse to <http://localhost:8080> and wait until the Unlock Jenkins page appears.
  2. From the Jenkins console log output, copy the automatically-generated alphanumeric password (between the 2 sets of asterisks).
  3. On the Unlock Jenkins page, paste this password into the Administrator password field and click Continue.

---

## Add ssh

### Links

* <https://www.jenkins.io/doc/book/using/using-agents/>

### Steps

  1. Browse to <http://localhost:8080/manage/credentials/store/system/domain/_/newCredentials>
  2. Fill in the form:
     * Kind: SSH Username with private key;
     * id: jenkins
     * description: The jenkins ssh key
     * username: jenkins
     * Private Key: select Enter directly and press the Add button to insert the content of your private key file at ~/.ssh/jenkins_agent_key
     * Passphrase: fill your passphrase used to generate the SSH key pair (leave empty if you didn’t use one at the previous step)

---

## Add a new node (Jenkins recommendation)

  1. Browse to <http://localhost:8080/computer/>
  2. Click the 'New node' button
  3. Fill the Node/agent name and select the type; (e.g. Name: agent-1, Type: Permanent Agent) click on the Create button
  4. Fill the form:
     * Remote root directory; (e.g.: /home/jenkins )
     * label; (e.g.: agent1 )
     * Launch method; (e.g.: Launch agents by SSH )
       * Host; (e.g.:  or your IP address )
       * Credentials; (e.g.: jenkins )
       * Host Key verification Strategy; (e.g.: Manually trusted key verification …​ )
  5. Press the Save button and the agent1 will be registered, but offline for the time being. Click on it.  

---

## Install NodeJS Plugin

### Links

   * <https://plugins.jenkins.io/nodejs/>

 ### Steps

  1. Open Manage Jenkins => “Manage Plugins” and Install NodeJs Plugin and NPM Plugin.