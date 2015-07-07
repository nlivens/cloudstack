(function (cloudStack) {
  cloudStack.plugins.sfSharedVolume = function(plugin) {
    plugin.ui.addSection({
      id: 'sfSharedVolume',
      title: 'Shared Volume',
      preFilter: function(args) {
        return true;
      },
      listView: {
        id: 'sfSharedVolumes',
        fields: {
          name: { label: 'label.name' },
          iqn: { label: 'IQN' },
          size: { label: 'Size (GB)' },
          miniops: { label: 'Min IOPS' },
          maxiops: { label: 'Max IOPS' },
          burstiops: { label: 'Burst IOPS' }
        },
        dataProvider: function(args) {
          plugin.ui.apiCall('listSolidFireVolumes', {
            success: function(json) {
              var sfvolumes = json.listsolidfirevolumesresponse.sfvolume;

              args.response.success({ data: sfvolumes });
            },
            error: function(errorMessage) {
              args.response.error(errorMessage);
            }
          });
        },
        detailView: {
          name: 'Shared volume details',
          isMaximized: true,
          actions: {
            edit: {
              label: 'Edit shared volume',
              compactLabel: 'label.edit',
              action: function(args) {
                var sharedVolumeObj = args.context;
              }
            }
          }
        }
      },
      actions: {
        add: {
          label: 'Add Shared Volume',
          preFilter: function(args) {
            return true;
          },
          messages: {
            notification: function(args) {
              return 'Add Shared Volume';
            }
          }
        }
      }
    });
  };
}(cloudStack));