%====================================================================================
% ledsonar description   
%====================================================================================
context(ctxledsonar, "localhost",  "TCP", "8068").
context(ctxsonarresource, "192.168.178.64",  "TCP", "8028").
 qactor( sonarresource, ctxsonarresource, "external").
  qactor( sonarsimulator, ctxledsonar, "sonarSimulator").
  qactor( sonardatasource, ctxledsonar, "sonarHCSR04Support2021").
  qactor( datacleaner, ctxledsonar, "dataCleaner").
  qactor( distancefilter, ctxledsonar, "distanceFilter").
  qactor( sonar, ctxledsonar, "it.unibo.sonar.Sonar").
  qactor( led, ctxledsonar, "it.unibo.led.Led").
msglogging.
